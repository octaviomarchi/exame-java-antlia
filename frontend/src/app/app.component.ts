import {Component, OnInit} from '@angular/core';
import {SpringApiService} from "./services/spring-api.service";
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
  title: string = 'Movimentos Manuais';
  products: Product[] = new Array<Product>();
  produtoCosifArray: ProdutoCosif[] = new Array<ProdutoCosif>();
  movimentoManualArray: MovimentoManual[] = new Array<MovimentoManual>();

  constructor(private springApiService: SpringApiService) {
  }

  ngOnInit() {
    this.springApiService.getProducts().subscribe({
      next: (response: Product[]) => {
      this.products = response;
    }
  });
  }

  getProdutoCosif(codigoProduto): void {
    this.springApiService.getProdutoCosif(codigoProduto).subscribe({
      next: (response: ProdutoCosif[]) => {
        this.produtoCosifArray = response;
      }
    });
  }

  saveMovimentoManual(movimentoManualRequest: MovimentoManualRequest): void {
    this.springApiService.postMovimentoManual(movimentoManualRequest).subscribe({
      next: (response: MovimentoManual) => {
        this.movimentoManualArray.push(response);
      }
    });
  }
}
