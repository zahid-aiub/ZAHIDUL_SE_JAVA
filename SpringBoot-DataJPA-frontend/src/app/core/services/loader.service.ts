import { Injectable, Input } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoaderService {
  loading: boolean;
  @Input() loadingSubject: Subject<boolean>;
  constructor() {
    this.loading = true;
    this.loadingSubject = new Subject<boolean>();
  }
  showLoader() {
    console.log('SHOWING LOADER');
    this.loading = true;
    this.loadingSubject.next(true);
  }
  hideLoader() {
    console.log('HIDING LOADER');
    this.loading = false;
    this.loadingSubject.next(false);
  }

  scrollToTop() {
    const scrollToTop = window.setInterval(() => {
      const pos = window.pageYOffset;
      if (pos > 0) {
        window.scrollTo(0, pos - 30); // how far to scroll on each step
      } else {
        window.clearInterval(scrollToTop);
      }
    }, 20);
  }

}
