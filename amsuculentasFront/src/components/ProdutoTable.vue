<!--amsuculentasFront\src\components\ProdutoTable.vue-->

<template>
  <v-data-table
    :items="localProdutos"
    :headers="headers"
    item-value="id"
  >
    <!-- IMAGEM -->
    <template #item.imagem="{ item }">
      <v-img
        :src="getImagem(item.imagem)"
        width="50"
        height="50"
      />
    </template>

    <!-- ATIVO -->
    <template #item.ativo="{ item }">
      <v-switch
        :model-value="item.ativo"
        @update:modelValue="(value: any) => onToggle(item.id, value)"
      />
    </template>
  </v-data-table>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue'

/* =========================
   TYPES
========================= */
interface Produto {
  id: number
  nome: string
  preco: number
  estoque: number
  promocao: boolean
  ativo: boolean
  imagem?: string
}

/* =========================
   PROPS
========================= */
const props = defineProps<{
  produtos: Produto[]
}>()

/* =========================
   EMITS
========================= */
const emit = defineEmits<{
  (e: 'atualizar', payload: { id: number; data: Partial<Produto> }): void
}>()

/* =========================
   STATE LOCAL (evita mutar props)
========================= */
const localProdutos = ref<Produto[]>([])

watch(
  () => props.produtos,
  (newVal) => {
    localProdutos.value = newVal.map(p => ({ ...p }))
  },
  { immediate: true }
)

/* =========================
   HEADERS
========================= */
const headers = [
  { title: 'ID', key: 'id' },
  { title: 'Nome', key: 'nome' },
  { title: 'Preço', key: 'preco' },
  { title: 'Estoque', key: 'estoque' },
  { title: 'Promoção', key: 'promocao' },
  { title: 'Ativo', key: 'ativo' },
  { title: 'Imagem', key: 'imagem' }
]

/* =========================
   METHODS
========================= */
function onToggle(id: number, value: boolean) {
  // atualiza local
  const produto = localProdutos.value.find(p => p.id === id)
  if (produto) produto.ativo = value

  // emite pro pai
  emit('atualizar', {
    id,
    data: { ativo: value }
  })
}

function getImagem(img?: string) {
  if (!img) return '/assets/sem-imagem.png'

  if (img.startsWith('http')) return img

  if (img.startsWith('/assets')) return img

  return `/assets/produtosImg/${img}`
}
</script>