import { Component, OnInit, Input, ChangeDetectorRef, HostListener } from '@angular/core';
import { LoaderService } from '../core/services/loader.service';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.css']
})
export class LoaderComponent implements OnInit {
  loading: boolean;
  loaderCall = 0;

  @HostListener('document:keydown.escape', ['$event']) onKeydownHandler(event: KeyboardEvent) {
    const keyCode = event.keyCode;
    if (keyCode === 27) {
      this.loaderService.hideLoader();
    }
  }

  constructor(
    public loaderService: LoaderService,
    private cdr: ChangeDetectorRef) {
    this.loading = true;
  }

  ngOnInit() {
    if (this.loaderService.loadingSubject) {
      this.loaderService.loadingSubject.subscribe((event) => {
        this.loading = event;
        this.cdr.detectChanges();
      });
    }
  }
}
