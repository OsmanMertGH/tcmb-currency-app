import { Component } from '@angular/core';
import axios from 'axios';
import { Currency } from './Currency';
@Component({
  selector: 'app-currency-list',
  templateUrl: './currency-list.component.html',
  styleUrls: ['./currency-list.component.css']
})
export class CurrencyListComponent {

  constructor() {
    this.selectedDate = new Date().toISOString().slice(0, 10);
  }
  selectedDate: string = '';
  showCurrencies: boolean = false;
  currencies: Currency[] = [];
  resultMessage:string ='';
  async search() {


    const res = await axios.get("http://localhost:8080/api/"+this.selectedDate.toString());

    if (res.data.result) {
      this.showCurrencies = true;
      this.currencies = res.data.result;
    }else{
      this.resultMessage=res.data.resultMessage;
      this.showCurrencies = false;
    }

  }
}


