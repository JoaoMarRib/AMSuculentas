import { api } from './api'


export interface Produto {
  id: number
  nome: string
  preco: number
  estoque: number
  promocao: boolean
  ativo: boolean
  imagem?: string
}

export type ProdutoCreate = Omit<Produto, 'id'>
export type ProdutoUpdate = Partial<Produto>


export const produtoService = {
  listar() {
    return api.get<Produto[]>('/produtos')
  },

  listarPublicos() {
    return api.get<Produto[]>('/produtos/publicos')
  },

  criar(data: ProdutoCreate) {
    return api.post('/produtos', data)
  },

  atualizar(id: number, data: ProdutoUpdate) {
    return api.put(`/produtos/${id}`, data)
  },

  uploadImagem(id: number, formData: FormData) {
    return api.post(`/produtos/${id}/imagem`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
  }
}