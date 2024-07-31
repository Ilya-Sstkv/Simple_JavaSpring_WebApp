package SimpleSpring.controllers;

import SimpleSpring.dao.CarDAO;
import SimpleSpring.models.Car;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarDAO carDAO;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("cars", carDAO.index());
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("car", carDAO.show(id));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newCar(Model model){
        model.addAttribute("newCar", new Car());
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("newCar") @Valid Car car, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "cars/new";
        carDAO.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("editCar", carDAO.show(id));
        model.addAttribute("currentId", id);
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("editCar") @Valid Car car,
                         BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors())
            return "cars/edit";
        carDAO.update(id, car);
        return "redirect:/cars/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        carDAO.delete(id);
        return "redirect:/cars";
    }
}