<template>
  <v-container fluid class="pa-0">

    <!-- NAVBAR -->
    <v-app-bar app color="#F0F0F0" flat>
      <v-img src="/assets/icons/iconverdeerosa.png" max-width="40" />
      <v-spacer />
      <v-btn text href="#sobre">Sobre</v-btn>
      <v-btn text href="#catalogo">Produtos</v-btn>
      <v-btn text href="#depoimentos">Avaliações</v-btn>
    </v-app-bar>

    <!-- HEADER -->
    <v-sheet height="500" class="d-flex align-center justify-center" style="position:relative;">
      <v-img
        src="/assets/img/banner.png"
        cover
        style="position:absolute; inset:0;"
      />
      <div class="text-center" style="z-index:2;">
        <h1 class="text-h3 text-white">A.M. Suculentas</h1>
        <p class="text-white">Cultivando lembranças</p>
      </div>
    </v-sheet>

    <!-- PROMOÇÕES -->
    <v-container class="py-10">
      <v-row>
        <v-col v-for="(promo, i) in promocoes" :key="i" cols="12" md="3">
          <v-card>
            <v-img :src="promo.img" height="200" />
            <v-card-title>{{ promo.titulo }}</v-card-title>
            <v-card-text>{{ promo.texto }}</v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <!-- CATÁLOGO -->
    <v-container id="catalogo">
      <h2 class="text-h4 mb-5">Nosso Catálogo</h2>

      <v-row>
        <v-col
          v-for="produto in produtos"
          :key="produto.id"
          cols="12"
          md="4"
        >
          <v-card>
            <v-img :src="getImagem(produto.imagem)" height="200" />

            <v-card-title>{{ produto.nome }}</v-card-title>

            <v-card-text>
              <div v-if="produto.promocao > 0">
                <span style="text-decoration: line-through;">
                  R$ {{ produto.preco }}
                </span>
                <br />
                <strong class="text-green">
                  R$ {{ precoComDesconto(produto) }}
                </strong>
              </div>
              <div v-else>
                R$ {{ produto.preco }}
              </div>
            </v-card-text>

          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <!-- ORÇAMENTO -->
    <v-container class="py-10">
      <h2 class="text-h4 mb-5">Faça seu orçamento</h2>

      <v-form @submit.prevent="enviarOrcamento">
        <v-text-field v-model="form.nome" label="Nome" />
        <v-text-field v-model="form.email" label="Email" />
        <v-text-field v-model="form.telefone" label="Telefone" />

        <v-select
          v-model="form.produto"
          :items="produtos"
          item-title="nome"
          item-value="id"
          label="Produto"
        />

        <v-text-field v-model="form.quantidade" type="number" label="Quantidade" />

        <v-textarea v-model="form.obs" label="Observações" />

        <v-btn type="submit" color="green">Enviar</v-btn>
      </v-form>
    </v-container>

    <!-- DEPOIMENTOS -->
    <v-container id="depoimentos">
      <h2 class="text-h4 mb-5">Depoimentos</h2>

      <v-row>
        <v-col cols="12" md="4" v-for="d in depoimentos" :key="d.nome">
          <v-card class="pa-4 text-center">
            <v-avatar size="80">
              <v-img :src="d.img" />
            </v-avatar>
            <h3>{{ d.nome }}</h3>
            <p>{{ d.texto }}</p>
          </v-card>
        </v-col>
      </v-row>
    </v-container>

    <!-- FOOTER -->
    <v-footer class="text-center pa-5">
      <div>© AM Suculentas</div>
    </v-footer>

  </v-container>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { produtoService } from '@/services/produtoService'

const produtos = ref<any[]>([])

const form = ref({
  nome: '',
  email: '',
  telefone: '',
  produto: null,
  quantidade: 1,
  obs: ''
})

const promocoes = [
  {
    titulo: 'Dia das Mães',
    texto: 'Presenteie com suculentas',
    img: '/assets/img/Img_mae.jpg'
  },
  {
    titulo: 'Promoção',
    texto: 'Desconto acima de 10 unidades',
    img: '/assets/img/Img_promo.jpg'
  }
]

const depoimentos = [
  {
    nome: 'Sandra',
    texto: 'Sou apaixonada por suculentas!',
    img: '/assets/sandra.jpg'
  },
  {
    nome: 'Alessandra',
    texto: 'Mudou meu dia a dia.',
    img: '/assets/alessandra.jpg'
  }
]

onMounted(async () => {
  const res = await produtoService.listarPublicos()
  produtos.value = res.data
})

function precoComDesconto(produto: any) {
  return (produto.preco * (100 - produto.promocao) / 100).toFixed(2)
}

function getImagem(img: string) {
  if (!img) return '/assets/produtosImg/sem-imagem.png'
  return img.startsWith('/assets') ? img : `/assets/produtosImg/${img}`
}

function enviarOrcamento() {
  console.log('Orçamento enviado:', form.value)
}
</script>

<style scoped>
.text-green {
  color: #00aa00;
}
</style>