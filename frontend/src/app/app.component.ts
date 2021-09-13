import {Component, OnInit} from '@angular/core';
import {SpringApiService} from "./spring-api.service";
import {Product} from "./models/product";
import {ProdutoCosif} from "./models/produto-cosif";
import {MovimentoManualRequest} from "./models/movimento-manual-request";
import {MovimentoManual} from "./models/movimento-manual";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'frontend';
  products: Product[] = new Array<Product>();
  produtoCosifArray: ProdutoCosif[] = new Array<ProdutoCosif>();
  movimentosManuais: MovimentoManual[] = new Array<MovimentoManual>();

  constructor(private springApiService: SpringApiService) {
  }

  ngOnInit() {
    this.springApiService.getProducts().subscribe(
      response => {
        this.products = response;
        console.log(this.products);
      }
    );
  }

  getProdutoCosif(codigoProduto): void {
    this.springApiService.getProdutoCosif(codigoProduto).subscribe({
      next: (response) => {
        this.produtoCosifArray = response;
      }
    });
  }

  saveMovimentoManual(movimentoManualRequest: MovimentoManualRequest): void {
    this.springApiService.postMovimentoManual(movimentoManualRequest).subscribe({
      next: (response) => {
        this.movimentosManuais.push(response);
      }
    });
  }
}
