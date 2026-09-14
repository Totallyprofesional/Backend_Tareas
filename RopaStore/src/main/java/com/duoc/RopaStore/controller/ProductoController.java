package com.duoc.RopaStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.RopaStore.model.Producto;
import com.duoc.RopaStore.service.ProductoService;

@RestController
public class ProductoController {
    @Autowired
    private ProductoService serv;

    @GetMapping("/productosTexto")
    public String mostrarProductosTexto() {
        return serv.obtenerProductosTexto();
    }

    @GetMapping("/productos")
    public List<Producto> mostrarProductos() {
        return serv.obtenerProductos();
    }

    @GetMapping("/productos/{id}")
    public Producto mostrarProducto(@PathVariable Integer id) {
        return serv.obtenerProducto(id).get();
    }

    @GetMapping("/productos/categoria/{categoria}")
    public List<Producto> mostrarProductosPorCategoria(@PathVariable String categoria) {
        return serv.obtenerProductosPorCategoria(categoria);
    }
}