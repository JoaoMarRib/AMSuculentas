<!-- pages/admin/AdminProdutos.vue -->
<template>
  <v-container>
    <h1>Painel Admin</h1>

    <ProdutoForm @salvar="salvarProduto" />

    <ProdutoTable 
      :produtos="store.produtos"
      @atualizar="atualizarProduto"
    />
  </v-container>
</template>

<script setup lang="ts">
import { onMounted } from 'vue'
import { useProdutoStore } from '@/stores/produtoStore'
import ProdutoForm from '@/components/ProdutoForm.vue'
import ProdutoTable from '@/components/ProdutoTable.vue'

const store = useProdutoStore()

onMounted(() => {
  store.carregarProdutos()
})

function salvarProduto(produto: any) {
  store.criarProduto(produto)
}

function atualizarProduto({ id, data }: any) {
  store.atualizarProduto(id, data)
}
</script>