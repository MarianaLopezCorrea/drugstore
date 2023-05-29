import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MedicamentDto } from '../dto/medicament.dto';
import { SalesDto } from '../dto/sales.dto';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrlMedicaments = 'http://localhost:8090/api';
  private baseUrlSales = 'http://localhost:8091/api';

  constructor(private http: HttpClient) {}

  getSales(): Observable<SalesDto[]> {
    const url = `${this.baseUrlSales}/sale`;
    console.log(url);
    return this.http.get<SalesDto[]>(url);
  }

  getSalesByDate(url: string): Observable<SalesDto[]> {
    console.log(url);
    return this.http.get<SalesDto[]>(url);
  }

  getMedicaments(): Observable<MedicamentDto[]> {
    const url = `${this.baseUrlMedicaments}/medicament`;
    console.log(url);
    return this.http.get<MedicamentDto[]>(url);
  }

  createMedicament(url: string, medicament: MedicamentDto): Observable<any> {
    return this.http.post(url, medicament);
  }

  updateMedicament(url: string, medicament: MedicamentDto): Observable<any> {
    return this.http.put(url, medicament);
  }

  getUnitPrice(url: string): Observable<number> {
    return this.http.get<number>(url);
  }

  deleteMedicament(url: string): Observable<any> {
    return this.http.delete(url);
  }

  sellMedicament(url: string, medicamentId: number): Observable<any> {
    return this.http.put(url, medicamentId);
  }

}
