package com.unifacisa.tap.usuarioservice.service;

import com.unifacisa.tap.usuarioservice.domain.Produto;
import com.unifacisa.tap.usuarioservice.repository.ProdutoRepository;
import com.unifacisa.tap.usuarioservice.service.dto.ProdutoDTO;
import com.unifacisa.tap.usuarioservice.service.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> Produtos = produtoRepository.findAll();
        return Produtos.stream()
                .map(ProdutoMapper.INSTANCE::produtoToDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarProdutoPorId(Long id) {
        Produto Produto = produtoRepository.findById(id).orElse(null);
        return ProdutoMapper.INSTANCE.produtoToDTO(Produto);
    }

    public ProdutoDTO criarOuAtualizarProduto(ProdutoDTO produtoDTO) {
        if (Objects.isNull(produtoRepository.findById(produtoDTO.getId()))) {
            Produto Produto = ProdutoMapper.INSTANCE.dtoToProduto(produtoDTO);
            return ProdutoMapper.INSTANCE.produtoToDTO(produtoRepository.save(Produto));
        }
        Produto ProdutoAtualizado = ProdutoMapper.INSTANCE.dtoToProduto(produtoDTO);
        return ProdutoMapper.INSTANCE.produtoToDTO(produtoRepository.save(ProdutoAtualizado));
    }

    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}
