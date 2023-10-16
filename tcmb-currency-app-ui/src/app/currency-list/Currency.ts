export class Currency{
    currencyCode: string;
    currencyName: string;
    forexBuying: number;
    forexSelling: number;
    banknoteBuying: number;
    banknoteSelling: number;


    constructor(
        _currencyCode: string,
        _currencyName: string,
        _forexBuying: number,
        _forexSelling: number,
        _banknoteBuying: number,
        _banknoteSelling: number
    ) {
        this.currencyCode = _currencyCode,
        this.currencyName = _currencyName,
        this.forexBuying=_forexBuying,
        this.forexSelling=_forexSelling
        this.banknoteBuying=_banknoteBuying
        this.banknoteSelling=_banknoteSelling
    }

}