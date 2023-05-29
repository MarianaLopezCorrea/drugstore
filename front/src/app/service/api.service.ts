import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MedicamentDto } from '../dto/medicament.dto';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8090/api';

  constructor(private http: HttpClient) {}

  getMedicaments(): Observable<MedicamentDto[]> {
    const url = `${this.baseUrl}/medicament`;
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
