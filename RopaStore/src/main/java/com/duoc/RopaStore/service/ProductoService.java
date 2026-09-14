package com.duoc.RopaStore.service;

import com.duoc.RopaStore.model.Producto;
import com.duoc.RopaStore.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repo;

    public List<Producto> obtenerProductos() {
        return repo.findAll();
    }

    public Optional<Producto> obtenerProducto(int id) {
        return repo.findById(id);
    }

    public List<Producto> obtenerProductosPorCategoria(String categoria) {
        return repo.findAll().stream()
                    .filter((p) -> p.getCategoria().equalsIgnoreCase(categoria))
                    .toList();
    }

    public String obtenerProductosTexto() {
        StringBuilder sb = new StringBuilder();
        List<Producto> productos = repo.findAll();

        for (Producto p : productos) {
            sb.append(String.format("""
                Producto %d:
                Nombre: %s
                Categoría: %s
                Talla: %s
                Precio: %.0f
                Stock: %d
                """,
                p.getId(),
                p.getNombre(),
                p.getCategoria(),
                p.getTalla(),
                p.getPrecio(),
                p.getStock()
            ));
        }

        return sb.toString();
    }
}