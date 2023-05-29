import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PanelModule } from 'primeng/panel';
import { CardModule } from 'primeng/card';
import { CalendarModule } from 'primeng/calendar';
import { InputTextModule } from 'primeng/inputtext';
import { TableModule } from 'primeng/table';
import { DatePipe } from '@angular/common';
import { SellModalComponent } from '../app/sell-modal/sell-modal.component';
import { DialogModule } from 'primeng/dialog';
import { SalesComponent } from './sales/sales.component';

@NgModule({
  declarations: [
    AppComponent,
    SellModalComponent,
    SalesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    PanelModule,
    CardModule,
    CalendarModule,
    InputTextModule,
    TableModule,
    DialogModule
  ],
  providers: [DatePipe], // Mueve DatePipe a la lista de proveedores
  bootstrap: [AppComponent]
})
export class AppModule { }

