import { ProductService } from './product.service';
import { Product } from './product';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  products: Product[];
  activeEditing = -1;
  editingProduct: Product | null;
  addingProduct = false;
  tempSaveProduct: Product = new Product();

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.listProducts();
  }

  listProducts(): void {
    this.productService.getProductList().subscribe((data) => {
      this.products = data;
    });
  }

  removeProduct(product: Product): void {
    this.productService.removeProduct(product).subscribe(() => {
      this.listProducts();
    });
  }

  cancelEditing(event: Event): void {
    event.preventDefault();
    this.activeEditing = -1;
  }

  editProduct(i: number, event: Event): void {
    event.preventDefault();
    this.productService.updateProduct(this.editingProduct).subscribe(() => {
      this.activeEditing = -1;
      this.listProducts();
    });
  }

  openEditProduct(i: number): void {
    if (this.activeEditing === i) {
      this.activeEditing = -1;
      this.editingProduct = null;
    } else {
      this.activeEditing = i;
      this.editingProduct = { ...this.products[i] };
    }
  }

  cancelAdd(event: Event): void {
    event.preventDefault();
    this.tempSaveProduct = new Product();
    this.addingProduct = false;
  }

  saveProduct(event: Event): void {
    event.preventDefault();
    this.productService.createProduct(this.tempSaveProduct).subscribe(() => {
      this.listProducts();
      this.addingProduct = false;
      this.tempSaveProduct = new Product();
    });
  }
}
