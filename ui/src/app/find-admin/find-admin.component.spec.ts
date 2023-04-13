import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindAdminComponent } from './find-admin.component';

describe('FindAdminComponent', () => {
  let component: FindAdminComponent;
  let fixture: ComponentFixture<FindAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FindAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
