import React, { useState } from 'react';
import style from './InputLabel.module.scss';

const InputLabel = (props) => {
    const [value, setValue] = useState('');

    return (
        <div>
            <label htmlFor={tag}>{item[0]}</label>
            <input type="text" name={tag} id={tag} value={data[tag]} className={style.main__form__details__list__input}/>
        </div>
    );
};

export default InputLabel;