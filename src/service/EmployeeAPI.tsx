export const processDate = (date: string) => {
    let [year,month,day] = date.split('-');
   return [parseInt(year), parseInt(month), parseInt(day)];
}

export const recombineDate = (year: number, month: number, day:number)  => {
    let dayString: string = `${day}`;
    let monthString: string = `${month}`;
    dayString.length == 1 ? dayString = `0${day}`: null;
    monthString.length == 1 ? monthString = `0${month}` : null;
    
    return `${year}-${monthString}-${dayString}`
}