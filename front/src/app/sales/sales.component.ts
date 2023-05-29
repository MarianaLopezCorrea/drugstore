import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { SalesDto } from '../dto/sales.dto';
import { DateBetweenDto } from '../dto/dateBetween.dto';


@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.scss']
})
export class SalesComponent implements OnInit {
  sales: SalesDto[] = [];
  dateBetweenDto: DateBetweenDto[] = [];
  dateDialog: boolean = false;
  submitted: boolean = false;

  dateBetween = {
    startDate: "",
    endDate: ""
  };
  

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    console.log("entro a getSale");
    this.getSale();
  }

  getWin() {
    this.dateDialog = true;
    this.submitted = false;
}

hideDialog() {
  this.dateDialog = false;
  this.submitted = false;
  this.dateBetween.startDate = '';
  this.dateBetween.endDate = '';
}

  getSale() {
    this.apiService.getSales().subscribe(
      response => {
        this.sales = response;
        console.log(this.sales);
      },
      error => {
        console.log(error);
      }
    );
  }

  getSaleByDate(dateBetween: DateBetweenDto) {
    console.log("entro a getSaleByDate");
    this.dateDialog = false;
    const url = `http://localhost:8091/api/sale/filter_by_date?startDate=${dateBetween.startDate}&endDate=${dateBetween.endDate}`;
    this.submitted = true;
    this.dateBetween.startDate = '';
    this.dateBetween.endDate = '';
    this.apiService.getSalesByDate(url).subscribe(
      response => {
        this.sales = response;
        console.log(this.sales);
      },
      error => {
        console.log(error);
      }
    );
  }
}
