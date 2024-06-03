import { Component, Input } from '@angular/core';
import { SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-iframe',
  templateUrl: './iframe.component.html',
  styleUrl: './iframe.component.css'
})
export class IframeComponent {
  @Input() url: SafeResourceUrl = '';
}
