import { Component, ViewEncapsulation, ViewChild } from '@angular/core';
import {
  ApexChart,
  ChartComponent,
  ApexDataLabels,
  ApexLegend,
  ApexStroke,
  ApexTooltip,
  ApexAxisChartSeries,
  ApexXAxis,
  ApexYAxis,
  ApexGrid,
  ApexPlotOptions,
  ApexFill,
  ApexMarkers,
  ApexResponsive,
} from 'ng-apexcharts';

interface stats {
  id: number;
  time: string;
  color: string;
  subtext?: string;
  title?: string;
  link?: string;
}

export interface productsData {
  id: number;
  uname: string;
  position: string;
  productName: string;
  date: string;
  priority: string;
  hour: string;
}

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
  encapsulation: ViewEncapsulation.None,
})
export class AppBadgeComponent {
  @ViewChild('chart') chart: ChartComponent = Object.create(null);

  displayedColumns: string[] = ['assigned', 'name', 'priority', 'date', 'hour'];
  dataSource: productsData[] = [];
  stats: stats[] = [];

  constructor() {
    // Charger les données récentes des transactions depuis la base
    this.stats = [
      {
        id: 1,
        time: '09:00 am',
        color: 'primary',
        subtext: 'Consultation confirmée avec Dr. Martin.',
      },
      {
        id: 2,
        time: '10:30 am',
        color: 'accent',
        subtext: 'Consultation annulée avec Dr. Durand.',
      },
      {
        id: 3,
        time: '12:00 pm',
        color: 'success',
        subtext: 'Nouvelle consultation ajoutée avec Dr. Dupont.',
      },
    ];

    // Charger les données des médecins en tant que "Top Projects"
    this.dataSource = [
      {
        id: 1,
        uname: 'Jean Dupont',
        position: 'Cardiologie',
        productName: 'Centre Médical Paris',
        date: '27/01/25',
        priority: 'critical',
        hour: '10h00',
      },
      {
        id: 2,
        uname: 'Marie Curie',
        position: 'Neurologie',
        productName: 'Centre Médical Lyon',
        date: '30/01/25', // Exemple de budget
        priority: 'high',
        hour: '16h30',
      },
    ];
  }
}
