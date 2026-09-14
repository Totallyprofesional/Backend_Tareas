package com.duoc.RopaStore.repository;

import com.duoc.RopaStore.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private List<Producto> productos = new ArrayList<>();

    public ProductoRepository() {
        productos.add(new Producto(1, "Polera básica", "Poleras", "M", 9990, 20));
        productos.add(new Producto(2, "Pantalón jeans", "Pantalones", "L", 24990, 10));
        productos.add(new Producto(3, "Zapatillas urbanas", "Zapatos", "42", 39990, 5));
    }

    public List<Producto> findAll() {
        return productos;
    }

    public Optional<Producto> findById(Integer id) {
        return productos.stream().filter((p) -> p.getId() == id).findFirst();
    }

    public boolean existsById(Integer id) {
        return !findById(id).isEmpty();
    }

    public long count() {
        return productos.size();
    }
}