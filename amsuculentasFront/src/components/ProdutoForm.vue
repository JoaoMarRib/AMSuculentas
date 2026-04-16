<!--amsuculentasFront\src\components\ProdutoForm.vue-->

<template>
  <v-form @submit.prevent="submit">
    <v-text-field v-model="form.nome" label="Nome" />
    <v-text-field v-model="form.preco" label="Preço" />
    <v-text-field v-model="form.estoque" label="Estoque" type="number" />
    <v-text-field v-model="form.promocao" label="Promoção" />

    <v-select
      v-model="form.ativo"
      :items="[true, false]"
      label="Ativo"
    />

    <v-btn type="submit">Salvar</v-btn>
  </v-form>
</template>

<script setup lang="ts">
import { reactive } from 'vue'

const emit = defineEmits(['salvar'])

const form = reactive({
  nome: '',
  preco: 0,
  estoque: 0,
  promocao: 0,
  ativo: true
})

function submit() {
  emit('salvar', { ...form })
}
</script>