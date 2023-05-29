import { Component, OnInit } from '@angular/core';
import { MedicamentDto } from './dto/medicament.dto';
import { ApiService } from './service/api.service';
import { DatePipe } from '@angular/common';
import { SalesComponent } from './sales/sales.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  medicaments: MedicamentDto[] = [];
  submitted: boolean = false;
  medicament!: MedicamentDto;
  formattedManufacturingDates: string[] = [];
  formattedExpirationDates: string[] = [];
  selectedMedicamentId: number;
  modalVisible: boolean = false;
  medicamentDialog: boolean = false;
  salesComponent: SalesComponent;

  constructor(private apiService: ApiService, private datePipe: DatePipe) {
    this.selectedMedicamentId = 0;
    this.salesComponent = new SalesComponent(this.apiService);
  }

  ngOnInit() {
    this.loadMedicaments();
  }

  loadMedicaments() {
    this.apiService.getMedicaments().subscribe(
      response => {
        this.medicaments = response;
        this.formatManufacturingDates();
        this.formatExpirationDates();
      },
      error => {
        console.log(error);
      }
    );
  }

  openNew() {
    this.medicament = {} as MedicamentDto;
    this.submitted = false;
    this.medicamentDialog = true;
}

  formatManufacturingDates() {
    this.formattedManufacturingDates = this.medicaments.map(medicament => {
      return medicament.manufacturingDate
        ? this.datePipe.transform(medicament.manufacturingDate, 'dd/MM/yyyy')!
        : '';
    });
  }

  formatExpirationDates() {
    this.formattedExpirationDates = this.medicaments.map(medicament => {
      return medicament.expirationDate
        ? this.datePipe.transform(medicament.expirationDate, 'dd/MM/yyyy')!
        : '';
    });
  }

  updateOrCreateMedicament(medicament: MedicamentDto) {
    this.medicamentDialog = false;
    this.submitted = true;
    
    if (medicament.id !== undefined) {
      const url = `http://localhost:8090/api/medicament/${medicament.id}`;
      this.apiService.updateMedicament(url, medicament).subscribe(
        response => {
          console.log('Medicamento actualizado exitosamente');
        },
        error => {
          console.log('Error al actualizar el medicamento', error);
        }
      );
      this.loadMedicaments();
    } else {
      const url = `http://localhost:8090/api/medicament`;
      this.apiService.createMedicament(url, medicament).subscribe(
        response => {
          console.log('Medicamento creado exitosamente');
        },
        error => {
          console.log('Error al crear el medicamento', error);
        }
      );
      this.loadMedicaments();
    }
  }


  deleteMedicament(medicament: MedicamentDto) {
    const url = `http://localhost:8090/api/medicament/${medicament.id}`;
    this.apiService.deleteMedicament(url).subscribe(
      response => {
        console.log('Medicamento eliminado exitosamente');
        this.loadMedicaments();
      },
      error => {
        console.log('Error al eliminar el medicamento', error);
      }
    );

  }

  confirmSale(medicament: MedicamentDto) {
    const quantity = 10;
    const url = `http://localhost:8091/api/sale/get_unit_price/${medicament.id}?quantity=${quantity}`;
    this.apiService.getUnitPrice(url).subscribe(
      unitPrice => {
        console.log('Precio unitario obtenido:', unitPrice);
        this.selectedMedicamentId = medicament.id; // Actualizar el medicamentId seleccionado
        this.modalVisible = true;
        this.loadMedicaments();
  
        // Ejecutar la carga de medicamentos cada segundo durante 10 segundos
        let counter = 0;
        const interval = setInterval(() => {
          this.loadMedicaments();
          counter++;
  
          if (counter >= 10) {
            clearInterval(interval);
          }
        }, 3000);
      },
      error => {
        console.log('Error al obtener el precio unitario del medicamento', error);
      }
    );
  }
  
  

  hideDialog() {
    this.medicamentDialog = false;
    this.submitted = false;
}

editProduct(medicament: MedicamentDto) {
  this.medicament = { ...medicament };
  this.medicamentDialog = true;
}

  onCloseModal() {
    this.modalVisible = false;
  }

}
