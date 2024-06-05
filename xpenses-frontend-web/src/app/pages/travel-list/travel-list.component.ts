import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-travel-list',
  templateUrl: './travel-list.component.html',
  styleUrl: './travel-list.component.css'
})
export class TravelListComponent {
  travels = [
     {
      id: 1,
      name: 'Viagens de Maio',
      startDate: '2024-05-01',
      endDate: '2024-05-31',
      employees: [
        { id: 101, name: 'João', status: 'para análise' },
        { id: 102, name: 'Maria', status: 'para análise' },
      ]
    },
    {
      id: 2,
      name: 'Feira de Profissões',
      startDate: '2024-08-01',
      endDate: '2024-08-31',
      employees: [
        { id: 101, name: 'Pedro', status: 'para análise' },
        { id: 102, name: 'Antônia', status: 'para análise' },
      ]
    },
    {
      id: 3,
      name: 'Feira de Profissões',
      startDate: '2024-08-01',
      endDate: '2024-08-31',
      employees: [
        { id: 101, name: 'Pedro', status: 'para análise' },
        { id: 102, name: 'Antônia', status: 'para análise' },
      ]
    }
  ];

  activeId: number | null = null;

  toggleAccordion(id: number) {
    if (this.activeId === id) {
      this.activeId = null;
    } else {
      this.activeId = id;
    }
  }

  isActive(id: number) {
    return this.activeId === id;
  }

  preventCollapse(event: Event) {
    event.stopPropagation();
  }

  constructor(private router: Router) {}
  
  analyzeExpense(itemId: number, subItemId: number) {
    this.router.navigate(['/travel/expenses', itemId, 'employee',subItemId]);
  }
}
