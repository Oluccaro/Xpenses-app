import { Component } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-expenses-list',
  templateUrl: './expenses-list.component.html',
  styleUrl: './expenses-list.component.css'
})
export class ExpensesListComponent {
  items = [
    {
      title: 'Gastos 1',
      subtitle: 'Mercados',
      description: 'Total: R$1000',
      link: 'https://www.fazenda.pr.gov.br/nfce/qrcode?p=41231243739437000154651100000693751161457949%7C2%7C1%7C1%7C839903E429C2EC5D88DBA3E64ED41770986FDF78',
      status: 'Em Análise'
    },
    {
      title: 'Gasto 2',
      subtitle: 'Primeiro dia do evento',
      description: 'Total: R$2000',
      link: 'https://www.fazenda.pr.gov.br/nfce/qrcode?p=41231243739437000154651100000693751161457949%7C2%7C1%7C1%7C839903E429C2EC5D88DBA3E64ED41770986FDF78',
      status: 'Em Análise'
    },
    {
      title: 'Gasto 3',
      subtitle: 'Transporte',
      description: 'Total: R$3000',
      link: 'https://example.com/item3',
      status: 'Em Análise'
    },
    {
      title: 'Gasto 4',
      subtitle: 'Jantar',
      description: 'Total: R$4000',
      link: 'https://example.com/item4',
      status: 'Em Análise'
    },
    {
      title: 'Item 5',
      subtitle: 'Subtítulo 5',
      description: 'Total: R$5000',
      link: 'https://example.com/item5',
      status: 'Em Análise'
    }
  ];

  constructor(private sanitizer: DomSanitizer, private router: Router) {}

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


  updateStatus(item: any, status: string) {
    if (item.status == status){
      item.status = 'Em Análise';
    }
    else {
      item.status = status;
    }
  }

  approveAll() {
    this.items.forEach(item => item.status = 'Aprovado');
  }

  rejectAll(){
    this.items.forEach(item => item.status = 'Rejeitado');
  }

  finishAnalysis() {
    // Here, you would typically send an email through a backend service.
    // Since this is a front-end example, we'll just log to the console and navigate back.
    const emailSubject = 'Analysis Completed';
    const emailBody = 'All items have been analyzed.';

    console.log(`Sending email with subject: ${emailSubject} and body: ${emailBody}`);
    
    // Navigate back to the item list page
    this.router.navigate(['/travel']);
  }
}
