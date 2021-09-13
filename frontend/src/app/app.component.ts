import {Component, OnInit} from '@angular/core';
import {SpringApiService} from "./spring-api.service";
import {Product} from "./models/product";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'frontend';
  products: Product[];

  constructor(private springApiService: SpringApiService) {
  }

  ngOnInit() {
    this.springApiService.getProducts().subscribe(
      response => {
        this.products = response;
      }
    );
  }
}
