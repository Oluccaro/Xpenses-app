import { Component } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-expenses-list',
  templateUrl: './expenses-list.component.html',
  styleUrl: './expenses-list.component.css'
})
export class ExpensesListComponent {
  items = [
    {
      title: 'Item 1',
      subtitle: 'Subtitle 1',
      description: 'Value: $1000',
      link: 'https://www.fazenda.pr.gov.br/nfce/qrcode?p=41231243739437000154651100000693751161457949%7C2%7C1%7C1%7C839903E429C2EC5D88DBA3E64ED41770986FDF78'
    },
    {
      title: 'Item 2',
      subtitle: 'Subtitle 2',
      description: 'Value: $2000',
      link: 'https://www.fazenda.pr.gov.br/nfce/qrcode?p=41231243739437000154651100000693751161457949%7C2%7C1%7C1%7C839903E429C2EC5D88DBA3E64ED41770986FDF78'
    },
    {
      title: 'Item 3',
      subtitle: 'Subtitle 3',
      description: 'Value: $3000',
      link: 'https://example.com/item3'
    },
    {
      title: 'Item 4',
      subtitle: 'Subtitle 4',
      description: 'Value: $4000',
      link: 'https://example.com/item4'
    },
    {
      title: 'Item 5',
      subtitle: 'Subtitle 5',
      description: 'Value: $5000',
      link: 'https://example.com/item5'
    }
  ];

  constructor(private sanitizer: DomSanitizer) {}

  iframeUrl: SafeResourceUrl = '';
  showModal: boolean = false;

  openInIframe(event: Event, url: string) {
    event.preventDefault();
    this.iframeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(url);
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
    this.iframeUrl = '';
  }
}
