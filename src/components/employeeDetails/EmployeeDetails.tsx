import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import style from './EmployeeDetails.module.scss';
import axios, {AxiosResponse} from 'axios';
import { processDate, recombineDate } from '../../service/EmployeeAPI';
import { useQuery, useMutation } from '@tanstack/react-query';

const EmployeeDetails = () => {
    const personal:Array<Array<string>> = [['First name', 'firstName'], ['Middle name (if applicable)', 'middleName'], ['Last name', 'lastName']];
    const contact:Array<Array<string>> = [['Email address', 'email', 'email'], ['Mobile number', 'phone', 'tel'], ['Residential address', 'address', 'text']];
    const {id} = useParams();
    const navigate = useNavigate();
    const [data, setData] = useState<{ [key: string]: string }>({});
    const [redo, setRedo] = useState(false);
    const [ongoing, setOngoing] = useState(false);
    const [startFinish, setStartFinish] = useState({
        startYear: 0,
        startMonth: 0,
        startDay: 0,
        finishYear: 0,
        finishMonth: 0,
        finishDay: 0
    });
    const [formData, setFormData] = useState({
      firstName: "",
      middleName: "",
      lastName: "",
      email: "",
      phone:"",
      address: "",
      permanent: true,
      startDate: "",
      finishDate: "",
      hoursPerWeek: 0,
      fullTime: true,
    });
    
    const handleInputChange = (event) => {
      const { name, value } = event.target;
      setFormData({
        ...formData,
        [name]: value,
      });
    };

    const handleDateChange = (event) => {
        const {name, value} = event.target;
        setStartFinish({
            ...startFinish,
            [name]: value,
        });

    }
    
    useEffect(() => {
        if (id){
            axios.get(`http://localhost:8080/employees/${id}`)
            .then(response => {
              setData(response.data);
              console.log(response.data);
        
              response.data.permanent
                ? document.getElementById('permanent')?.toggleAttribute('checked', true)
                : document.getElementById('contract')?.toggleAttribute('checked', true);
        
              response.data.fullTime
                ? document.getElementById('fullTime')?.toggleAttribute('checked', true)
                : document.getElementById('partTime')?.toggleAttribute('checked', true);
                
                response.data.finishDate == null ? setOngoing(true): null;
        
                //Store key value pairs
              for (const word of Object.keys(formData)) {
                if (word == 'finishDate' && !response.data[word]){
                    let today = new Date().toISOString().slice(0,10);
                    setOngoing(true);
                    formData[word] = today;
                } else {
                    formData[word] = response.data[word];
                }
                
              }

              //Transpose and store date
              [startFinish.startYear, startFinish.startMonth, startFinish.startDay] = processDate(response.data.startDate);
              [startFinish.finishYear, startFinish.finishMonth, startFinish.finishDay] = processDate(response.data.finishDate);
            })
            .catch((err) => {
              console.log(err);
            });

        }
    }, [redo]);
    

    const changeNavigate = (e:Event) => {
        e.preventDefault();
        navigate('/');

    }

    const cancelChange = (e:Event) => {
        e.preventDefault();
        setRedo(!redo);
    }

    const submitChanges = (e: Event) => {
        e.preventDefault();
        formData.startDate = recombineDate(startFinish.startYear, startFinish.startMonth, startFinish.startDay);
        formData.finishDate = recombineDate(startFinish.finishYear, startFinish.finishMonth, startFinish.finishDay);
        formData.fullTime = document.getElementById('fullTime')?.checked? true: false;
        formData.permanent = document.getElementById('permanent')?.checked? true: false;
        ongoing ? formData.finishDate = null: null;
        console.log(formData);
        const json = JSON.stringify(formData);
        if (parseInt(id)){
            axios.patch(`http://localhost:8080/employees/${id}`,json, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            alert('Your submission has been succesful')
        } else {
            axios.post(`http://localhost:8080/employees`,json, {
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            alert('You created an employee')

        }

    }

    return (
        <div className={style.main}>
            <p onClick={(e) => changeNavigate(e)} className={style.main__back}>Back</p>
            <h2 className={style.main__title}>Employee Details</h2>
            <form className={style.main__form}>
                <section className={style.main__form__details}>
                    <h3>Personal information</h3>
                    {personal.map(item => {
                        let tag:string = item[1];
                        return (<div className={style.main__form__details__list}>
                            <label htmlFor={tag}>{item[0]}</label>
                            <input type="text" name={tag} id={tag} value={formData[tag]} className={style.main__form__details__list__input} onChange={handleInputChange}/>
                        </div>)
                    })}
                </section>
                <section className={style.main__form__details}>
                    <h3>Contact details</h3>
                    {contact.map(item => {
                    let tag = item[1];
                    return (<div className={style.main__form__details__list}>
                        <label htmlFor={tag}>{item[0]}</label>
                        <input type={item[2]} name={tag} id={tag} value={formData[tag]} className={style.main__form__details__list__input} onChange={handleInputChange}/>
                    </div>)
                })}
                </section>
                <section className={style.main__form__details}>
                    <h3>Employee status</h3>
                    <div>
                        <input type="radio" name='permanent' id='permanent'/>
                        <label htmlFor="permanent">Permanent</label>
                        <input type="radio" name='permanent' id='contract'/>
                        <label htmlFor="contract">Contract</label>
                    </div>
                    <h4>Start date</h4> 
                    <div className={style.date}>
                        <div className={style.date__section}>
                            <h5>Day</h5>
                            <input type="number" id="startDay" name="startDay" value={startFinish.startDay} onChange={(e) => handleDateChange(e)}/>
                        </div> 
                        <div className={style.date__section}>
                            <h5>Month</h5>
                            <select name="startMonth" id="startMonth" value={startFinish.startMonth} onChange={(e) => handleDateChange(e)}>
                                <option value="1">January</option>
                                <option value="2">February</option>
                                <option value="3">March</option>
                                <option value="4">April</option>
                                <option value="5">May</option>
                                <option value="6">June</option>
                                <option value="7">July</option>
                                <option value="8">August</option>
                                <option value="9">September</option>
                                <option value="10">October</option>
                                <option value="11">November</option>
                                <option value="12">December</option>
                            </select>
                        </div>
                        <div className={style.date__section}>
                            <h5>Year</h5>
                            <input type="number" id="startYear" name="startYear" value={startFinish.startYear} onChange={(e) => handleDateChange(e)}/>
                        </div>
                    </div>
                    <h4>Finish date</h4> 
                    {!ongoing && <div className={style.date}>
                        <div className={style.date__section}>
                            <h5>Day</h5>
                            <input type="number" id="finishDay" name="finishDay" value={startFinish.finishDay} onChange={(e) => handleDateChange(e)}/>
                        </div> 
                        <div className={style.date__section}>
                            <h5>Month</h5>
                            <select name="finishMonth" id="finishMonth" value={startFinish.finishMonth} onChange={(e) => handleDateChange(e)}>
                                <option value="1">January</option>
                                <option value="2">February</option>
                                <option value="3">March</option>
                                <option value="4">April</option>
                                <option value="5">May</option>
                                <option value="6">June</option>
                                <option value="7">July</option>
                                <option value="8">August</option>
                                <option value="9">September</option>
                                <option value="10">October</option>
                                <option value="11">November</option>
                                <option value="12">December</option>
                            </select>
                        </div>
                        <div className={style.date__section}>
                            <h5>Year</h5>
                            <input type="number" id="finishYear" name="finishYear" value={startFinish.finishYear} onChange={(e) => handleDateChange(e)}/>
                        </div>
                    </div>}
                    <div>
                        <input type="checkbox" name='ongoing' id='ongoing' checked={ongoing} onChange={()=>setOngoing(!ongoing)}/>
                        <label htmlFor="ongoing">On going</label>
                    </div>
                    <div className={style.main__form__details}>
                        <h5>Is this on a full-time or part-time basis?</h5>
                        <div>
                            <input type="radio" name='fullPart' id='fullTime'/>
                            <label htmlFor="fulltime">Full-time</label>
                        </div>
                        <div>
                            <input type="radio" name='fullPart' id='partTime'/>
                            <label htmlFor="parttime">Part-time</label>

                        </div>
                        <label htmlFor="hoursPerWeek">Hours per week</label>
                        <input type="number" name='hoursPerWeek' id='hoursPerWeek' className={style.hoursInput} value={formData.hoursPerWeek} onChange={(e) => {handleInputChange(e)}}/>
                    </div>
                </section>
                <div className={style.buttons}>
                    <button onClick={(e) => {submitChanges(e)}}>Save</button>
                    <button onClick={(e) => {cancelChange(e)}}>Cancel</button>
                </div>
            </form>
        </div>
    );
};

export default EmployeeDetails;