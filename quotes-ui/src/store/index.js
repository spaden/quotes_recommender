import { configureStore } from '@reduxjs/toolkit'
import mlPredictionsReducer from './similarPred'

const store = configureStore({
    reducer: {
        mlPrediction: mlPredictionsReducer
    }
})

export default store