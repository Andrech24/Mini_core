import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { environment } from '../environments/environment';

interface ResultadoEnvio {
  repartidor: string;
  envios: number;
  totalKg: number;
  zona: string;
  tarifaKg: number;
  costoTotal: number;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  fechaInicio = '2025-05-01';
  fechaFin = '2025-05-31';
  resultados: ResultadoEnvio[] = [];
  mensaje = '';

  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.calcular();
  }

  calcular(): void {
    this.mensaje = '';

    if (this.fechaInicio > this.fechaFin) {
      this.mensaje = 'La fecha inicio no puede ser mayor que la fecha fin.';
      this.resultados = [];
      return;
    }

    const url = `${this.apiUrl}?fechaInicio=${this.fechaInicio}&fechaFin=${this.fechaFin}`;

    this.http.get<ResultadoEnvio[]>(url).subscribe({
      next: data => this.resultados = data,
      error: () => this.mensaje = 'No se pudo conectar con el backend Spring Boot.'
    });
  }

  totalEnvios(): number {
    return this.resultados.reduce((suma, item) => suma + item.envios, 0);
  }

  totalKg(): number {
    return this.resultados.reduce((suma, item) => suma + Number(item.totalKg), 0);
  }

  totalCosto(): number {
    return this.resultados.reduce((suma, item) => suma + Number(item.costoTotal), 0);
  }
}
