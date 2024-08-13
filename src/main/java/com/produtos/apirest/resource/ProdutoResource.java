package com.produtos.apirest.resource;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable(name = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
     public Produto salvarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    public void deletarProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    public Produto atualizarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

}
