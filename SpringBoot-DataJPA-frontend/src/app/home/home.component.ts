import {AfterViewInit, Component, OnDestroy, OnInit} from '@angular/core';
import {LoaderService} from '../core/services/loader.service';
import {ProductsService} from '../core/api/products.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, AfterViewInit, OnDestroy {

  public productList: any;
  constructor(
    private loaderService: LoaderService,
    private getProduct: ProductsService,
  ) {
  }

  ngOnInit() {
    this.getProduct.getAllProduct().subscribe( data => {
      this.productList = data;
    });
  }

  ngAfterViewInit() {
    this.loaderService.scrollToTop();
    this.loaderService.hideLoader();
  }

  ngOnDestroy() {
  }

}
