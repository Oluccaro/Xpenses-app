import { Component, Input, Output, EventEmitter } from '@angular/core';
import { SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {
  @Input() url: SafeResourceUrl = '';
  @Output() closeModalEvent = new EventEmitter();

  closeModal() {
    this.closeModalEvent.emit();
  }
}
