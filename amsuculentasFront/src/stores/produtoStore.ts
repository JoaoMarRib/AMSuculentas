// stores/produtoStore.ts
import { defineStore } from 'pinia'
import { produtoService } from '@/services/produtoService'

export const useProdutoStore = defineStore('produto', {
  state: () => ({
    produtos: [] as any[],
  }),

  actions: {
    async carregarProdutos() {
      const res = await produtoService.listar()
      this.produtos = res.data
    },

    async criarProduto(produto: any) {
      await produtoService.criar(produto)
      await this.carregarProdutos()
    },

    async atualizarProduto(id: number, data: any) {
      await produtoService.atualizar(id, data)
      await this.carregarProdutos()
    }
  }
})