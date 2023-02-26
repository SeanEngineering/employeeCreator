import * as employeeService from '../service/EmployeeAPI';
import { expect, test, describe, it } from 'vitest';

test('Date processing', () => {
    it('Should split ISO date string to year, month date array', () => {
        expect(employeeService.processDate('2023-01-02')).toBe([
            '2023',
            '01',
            '02',
        ]);
    });
    it('Should recombine dates to iso date string', () => {
        expect(employeeService.recombineDate('2023', '01', '02')).toBe(
            '2023-01-02'
        );
    });
});

test('Email processing', () => {
    it('It should process emails correctly', () => {
        expect(employeeService.checkEmail('sean@email.com')).toBe(true);
        expect(employeeService.checkEmail('sean.com')).toBe(false);
        expect(employeeService.checkEmail('sean@gmail')).toBe(false);
    });
});
