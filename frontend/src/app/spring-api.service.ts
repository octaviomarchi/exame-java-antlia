import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {Product} from "./models/product";
import {ProdutoCosif} from "./models/produto-cosif";

@Injectable({
  providedIn: 'root'
})
export class SpringApiService {

  private apiEndpoint: string = environment.APIEndpoint;

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiEndpoint + '/products');
  }

  getProdutoCosif(codigoProduto: string): Observable<ProdutoCosif[]> {
    return this.http.get<ProdutoCosif[]>(this.apiEndpoint + /products/ + codigoProduto + '/cosif');
  }
}
