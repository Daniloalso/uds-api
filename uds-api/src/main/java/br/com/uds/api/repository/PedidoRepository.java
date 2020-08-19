package br.com.uds.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.uds.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
