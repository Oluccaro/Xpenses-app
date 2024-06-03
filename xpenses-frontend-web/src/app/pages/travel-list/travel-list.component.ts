import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-travel-list',
  templateUrl: './travel-list.component.html',
  styleUrl: './travel-list.component.css'
})
export class TravelListComponent {
  items = [
    {
      id: 1,
      name: 'Category 1',
      subItems: ['Subitem 1.1', 'Subitem 1.2', 'Subitem 1.3']
    },
    {
      id: 2,
      name: 'Category 2',
      subItems: ['Subitem 2.1', 'Subitem 2.2', 'Subitem 2.3']
    },
    {
      id: 3,
      name: 'Category 3',
      subItems: ['Subitem 3.1', 'Subitem 3.2', 'Subitem 3.3']
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
    this.router.navigate(['/analysis', itemId, subItemId]);
  }
}
