import { Docente } from './docente';
import { Classe } from './classe';
import { RigaCalcolo } from './riga-calcolo';
import { RichiestaDto } from './richiesta-dto';
import { RispostaDto } from './risposta-dto';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  n1: number = 0;
  n2: number = 0;
  totale: number;
  righe: RigaCalcolo[] = [];

  classi: Classe[] = [];
  docenti: Docente[] = [];

  constructor(private http: HttpClient) { }

  somma() {
    let r: RichiestaDto = new RichiestaDto();
    r.numero1 = this.n1;
    r.numero2 = this.n2;

    let oss: Observable<RispostaDto> =
      this.http.post<RispostaDto>(
        "http://localhost:8080/somma",
        r
      );
    oss.subscribe(risp => {
      this.totale = risp.risultato;
      this.righe = risp.righe;
    });
  }

  sottrai() {
    let r: RichiestaDto = new RichiestaDto();
    r.numero1 = this.n1;
    r.numero2 = this.n2;

    let oss: Observable<RispostaDto> =
      this.http.post<RispostaDto>(
        "http://localhost:8080/sottrai",
        r
      );
    oss.subscribe(risp => {
      this.totale = risp.risultato;
      this.righe = risp.righe;
    });
  }

  mostraClassi() {
    let ox: Observable<Classe[]> =
      this.http.get<Classe[]>("http://localhost:8080/mostra-classi");
    ox.subscribe(r => this.classi = r);
  }

  mostraDocenti(c: Classe) {

    let ox: Observable<Docente[]> =
      this.http.post<Docente[]>(
        "http://localhost:8080/mostra-docenti",
        c);
    ox.subscribe(r => this.docenti = r);
  }
}
