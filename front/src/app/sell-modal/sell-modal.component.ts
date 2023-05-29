import { Component, Input, Output, EventEmitter } from '@angular/core';
import { ApiService } from '../service/api.service';
import { MedicamentDto } from '../dto/medicament.dto';



@Component({
  selector: 'app-sell-modal',
  templateUrl: './sell-modal.component.html',
  styleUrls: ['./sell-modal.component.scss']
})
export class SellModalComponent {
  @Input() medicamentId!: number;
  @Input() modalVisible!: boolean;
  @Output() closeModal: EventEmitter<void> = new EventEmitter<void>();
  @Output() confirmarVenta: EventEmitter<void> = new EventEmitter<void>();



  unitQuantity: number = 0;
  totalPurchase: number = 0;
  medicament!: MedicamentDto;

  constructor(private apiService: ApiService) {
  }

  calculateTotal() {
    const quantity = 1;
    const url = `http://localhost:8091/api/sale/get_unit_price/${this.medicamentId}?quantity=${quantity}`;
    this.apiService.getUnitPrice(url).subscribe(
      (price: number) => {
        this.totalPurchase = price * this.unitQuantity;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  sellMedicament() {
    console.log("id: " + this.medicamentId + " quantity: " + this.unitQuantity);
    const url = `http://localhost:8091/api/sale/confirm_sale/${this.medicamentId}?quantity=${this.unitQuantity}`;
    this.apiService.sellMedicament(url, this.medicamentId).subscribe(
      (response: any) => {
        console.log("id: " + this.medicamentId + " quantity: " + this.unitQuantity);
        console.log('Medicamento vendido exitosamente');
        this.closeModal.emit();
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  onCloseModal() {
    this.closeModal.emit();
  }

  onVentaConfirmada() {
    this.confirmarVenta.emit();
  }
}
