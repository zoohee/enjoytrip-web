import axios from "axios";
const { VITE_VUE_API_URL } = import.meta.env;

// local vue api axios instance
export function localAxios() {
  const instance = axios.create({
    baseURL: VITE_VUE_API_URL,
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },

    // withCredentials : true

  });

  return instance;
}

export const auth = (instance) => {
  const maxRetryAttempts = 2;
  let retryAttempts = 0;

  instance.interceptors.request.use(
    (config) => {
      const token = localStorage.getItem('access_token') || "";
      config.headers = {

        Authorization: `Bearer ${token}` || ''
      };

      return config;
    },
    (error) => Promise.reject(error.response)
  );

  // instance.interceptors.response.use(
  //   (response) => response,
  //   async (error) => {
      
  //     if (error.response && error.response.status === 401) {
  //       if (retryAttempts < maxRetryAttempts) {
  //         retryAttempts++;

  //       const refreshedToken = localStorage.getItem('refresh_token') || "";

  //       //  error.config.headers = {
  //       //   Authorization: `Bearer ${refreshedToken}` || ''
  //       // };
  //       const local = localAxios();
  //         const { data } = await local.post(
  //           '/member/refresh',
  //           refreshedToken,
  //         )
  //         console.log(data);
  //         error.config.headers['Authorization'] = `Bearer ${data.access_token}` || '';

  //        return instance(error.config);
  //     } else {
  //       // If max retry attempts exceeded, stop retrying and reject the promise
  //       return Promise.reject(error);
  //     }
  //   }

  //     return Promise.reject(error);
  //   }
  // );

  return instance;
};
