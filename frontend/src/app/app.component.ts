import {Component, OnInit} from '@angular/core';
import {SpringApiService} from "./spring-api.service";
import {Product} from "./models/product";
import {ProdutoCosif} from "./models/produto-cosif";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'frontend';
  products: Product[] = new Array<Product>();
  produtoCosifArray: ProdutoCosif[] = new Array<ProdutoCosif>();

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
}
