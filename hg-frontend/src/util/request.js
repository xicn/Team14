export const getHeaderWithOnlyJwtAuth = (jwt) => {
  return {
    headers: {
      Authorization: `Bearer ${jwt}`,
    },
  };
};
