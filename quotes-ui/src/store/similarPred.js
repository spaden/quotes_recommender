import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    predictions: ['testing123'],
    showPredictedModal: true,
    status: {
        isFetching: false,
        isFetched: false,
        error: false
    }
}

const mlPredictions = createSlice({
    name: 'mlPredictions',
    initialState: initialState,
    reducers: {
        FETCH_PREDICTIONS_REQUEST(state) {
            const { status } = state
            status.isFetching = true
            status.isFetched = false
            status.error = false 
            state.predictions = []
        },
        FETCH_PREDICTIONS_SUCCESS(state, payload) {
            const { status } = state
            status.isFetching = false
            status.isFetched = true
            status.error = false
            state.predictions = payload
        },
        FETCH_PREDICTIONS_ERROR(state) {
            const { status } = state
            status.isFetching = false
            status.isFetched = false
            status.error = true
        },
        SHOW_PREDICTED_MODAL(state) {
            state.showPredictedModal = !state.showPredictedModal
        }
    }
})
export const { FETCH_PREDICTIONS_REQUEST,
               FETCH_PREDICTIONS_SUCCESS,
               FETCH_PREDICTIONS_ERROR,
               SHOW_PREDICTED_MODAL
             } = mlPredictions.actions

/* export const fetchMlPredictions = async (payload) => {
    mlPredictionsActions.FETCH_PREDICTIONS_REQUEST()
    try {
        mlPredictionsActions.FETCH_PREDICTIONS_SUCCESS(['testing', 'testing'])
    } catch(e) {
        mlPredictionsActions.FETCH_PREDICTIONS_ERROR()
    }
} */

export default mlPredictions.reducer