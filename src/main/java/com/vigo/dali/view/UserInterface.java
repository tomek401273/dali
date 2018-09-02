package com.vigo.dali.view;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vigo.dali.model.Car;
import com.vigo.dali.model.CarRepository;
import org.vaadin.gridutil.cell.GridCellFilter;

@SpringUI
//@Theme("mytheme")
public class UserInterface extends UI {
    VerticalLayout layout;
    Grid<Car> carGrid;
    
    @Autowired
    CarRepository carRepository;
    
    public UserInterface() {
    	carGrid = new Grid<>(Car.class);
    }
    @Override
    protected void init(VaadinRequest request) {
        layout = new VerticalLayout();
        layout.addComponent(carGrid);
        carGrid.setItems(carRepository.findAll());
        layout.setSizeFull();
        layout.setExpandRatio(carGrid, 1f);
        carGrid.setSizeFull();
        layout.setMargin(false);
        setContent(layout);

        final GridCellFilter<Car> filter = new GridCellFilter(carGrid,Car.class);
        filter.setNumberFilter("id",Integer.class);
        filter.setTextFilter("model", true, true);
        filter.setTextFilter("interior", true, true);
        filter.setTextFilter("brand", true, true);
        filter.setNumberFilter("yearProduction",Integer.class);
        filter.setBooleanFilter("newState");
    }
}