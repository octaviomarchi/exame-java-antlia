import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Product} from "../models/product";
import {ProdutoCosif} from "../models/produto-cosif";
import {MovimentoManualRequest} from "../models/movimento-manual-request";
import {MovimentoManual} from "../models/movimento-manual";

@Injectable({
  providedIn: 'root'
})
export class SpringApiService {

  private apiEndpoint: string = environment.APIEndpoint;

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiEndpoint + '/produtos');
  }

  getProdutoCosif(codigoProduto: string): Observable<ProdutoCosif[]> {
    return this.http.get<ProdutoCosif[]>(this.apiEndpoint + /produtos/ + codigoProduto + '/cosif');
  }

  postMovimentoManual(movimentoManualRequest: MovimentoManualRequest): Observable<MovimentoManual> {
    return this.http.post<MovimentoManual>(this.apiEndpoint + '/movimentos-manuais', movimentoManualRequest);
  }
}
