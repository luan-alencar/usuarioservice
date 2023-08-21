package com.unifacisa.tap.usuarioservice.resource;

import com.unifacisa.tap.usuarioservice.repository.ProdutoRepository;
import com.unifacisa.tap.usuarioservice.service.ProdutoService;
import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoResource {

    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listarUsuarios() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoDTO buscarUsuario(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping
    public ProdutoDTO criarUsuario(@RequestBody ProdutoDTO dto) {
        return produtoService.criarOuAtualizarProduto(dto);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }

}

